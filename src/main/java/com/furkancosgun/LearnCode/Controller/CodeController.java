package com.furkancosgun.LearnCode.Controller;


import com.furkancosgun.LearnCode.Model.Code;
import com.furkancosgun.LearnCode.Util.CodeCompileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class CodeController {

    @PostMapping("api/compile")
    public @ResponseBody Code compile(@RequestBody Code code) throws IOException {

        File file = switch (code.getLanguage()) {
            case "javascript" -> new File("main.js");
            case "c++" -> new File("main.cpp");
            case "python" -> new File("main.py");
            case "go" -> new File("main.go");
            default -> new File("main" + "." + code.getLanguage());
        };

        String output = null;
        if (file.createNewFile()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(code.getCode()); // write Code on file
            writer.flush();
            System.out.println("XFC Code:" + code.getCode());
            writer.close();
            switch (code.getLanguage()) {
                case "go" -> output = CodeCompileUtil.compile("go run main.go");
                //You can write here python environment path (python -e)
                case "python" ->
                        output = CodeCompileUtil.compile("/Library/Developer/CommandLineTools/usr/bin/python3 main.py");
                case "javascript" -> output = CodeCompileUtil.compile("node main.js");
                case "c++" -> {
                    Process processCpp = Runtime.getRuntime().exec("g++ main.cpp -o main");
                    output = CodeCompileUtil.compile("./main");
                }
                case "c" -> {
                    Process processC = Runtime.getRuntime().exec("gcc main.c -o main");
                    output = CodeCompileUtil.compile("./main");
                }
                case "php" -> output = CodeCompileUtil.compile("php -f main.php");
            }

        }
        file.delete();
        return new Code(code.getLanguage(), output);
    }
}

