import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by claesdc on 2014-03-27.
 */
@RunWith(JUnit4.class)
public class NashornTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ScriptEngine nashorn;

    @Before
    public void setUp() {
        ScriptEngineManager manager = new ScriptEngineManager();
        System.setOut(new PrintStream(outContent));
        nashorn = manager.getEngineByName("nashorn");
    }

    @Test
    public void shouldEvaluateString() {

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

        assertNotNull(evalobj);
        assertEquals("Hello Nashorn!", evalobj.toString());
        assertEquals("Hello", outContent.toString().trim());
    }

    @Test
    public void shouldEvaluateJSFile() {
        Object evalobj = null;

        try {
            evalobj = nashorn.eval(new FileReader("js/NashornTest.js"));
            System.out.println(evalobj);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertNotNull(evalobj);
        assertEquals("Hello Nashorn!", evalobj.toString());

    }
}
