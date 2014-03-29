import nashorn.HelloWorld;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 *
 */
@RunWith(JUnit4.class)
public class NashornTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ScriptEngine nashorn;
    private ScriptEngineManager manager = new ScriptEngineManager();

    @Before
    public void setUp() {
       // System.setOut(new PrintStream(outContent));
//        nashorn = manager.getEngineByName("nashorn");
    }

    @Test
    public void shouldEvaluateString() {
        System.setOut(new PrintStream(outContent));
        nashorn = manager.getEngineByName("nashorn");
        Object evalobj = null;
        String jsstring = "var hello = function() {\n" +
                "  var str = \"Hello\";\n" +
                "  print(str);\n" +
                " return str + \" Nashorn!\";};" +
                " hello();";
        try {
            evalobj = nashorn.eval(jsstring);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        assertThat(evalobj, is(notNullValue()));
        assertEquals("Hello Nashorn!", evalobj.toString());
        assertEquals("Hello", outContent.toString().trim());
    }

    @Test
    public void shouldEvaluateJSFile() {
        nashorn = manager.getEngineByName("nashorn");
        Object evalobj = null;

        try {
            evalobj = nashorn.eval(new FileReader("js/NashornTest.js"));
            System.out.println(evalobj);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertThat(evalobj, is(notNullValue()));
        assertEquals("Hello Nashorn!", evalobj.toString());

    }

    @Test
    public void shouldLoadJavaInterfaceImplementationFromNashornScript() throws Exception {
        nashorn = manager.getEngineByName("nashorn");
        try {
            HelloWorld helloWorld = (HelloWorld)nashorn.eval(new FileReader("src/nashorn/helloWorld.js"));
            String hello = helloWorld.sayHello("Nashorn");

            assertEquals("Hey there Nashorn",hello);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
