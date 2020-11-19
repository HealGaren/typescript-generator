//package cz.habarta.typescript.generator.jsonvalue;
//
//import com.fasterxml.jackson.annotation.JsonValue;
//import cz.habarta.typescript.generator.Input;
//import cz.habarta.typescript.generator.Settings;
//import cz.habarta.typescript.generator.TestUtils;
//import cz.habarta.typescript.generator.TypeScriptGenerator;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
//
//public class InterfaceTest {
//
//    @Test
//    public void classValueGenericTest() {
//        final Settings settings = TestUtils.settings();
//        settings.mapPackagesToNamespaces = true;
//        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassValueGenericTestClass.class));
//        Assert.assertEquals(output, "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export interface RawClass {\n" +
//                "        member: string;\n" +
//                "    }\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export type ClassValueGenericTestClass = cz.habarta.typescript.generator.jsonvalue.InterfaceTest.RawClass[];\n" +
//                "\n" +
//                "}\n");
//    }
//
//    @Test
//    public void classValueGenericNotValueTest() {
//        final Settings settings = TestUtils.settings();
//        settings.mapPackagesToNamespaces = true;
//        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassValueGenericNotValueTestClass.class));
//        Assert.assertEquals(output, "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export interface ClassValueGenericNotValueTestClass {\n" +
//                "        test: cz.habarta.typescript.generator.jsonvalue.InterfaceTest.RawClass[];\n" +
//                "    }\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export interface RawClass {\n" +
//                "        member: string;\n" +
//                "    }\n" +
//                "\n" +
//                "}\n");
//    }
//
//    @Test
//    public void classValueNormalTest() {
//        final Settings settings = TestUtils.settings();
//        settings.mapPackagesToNamespaces = true;
//        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassValueNormalTestClass.class));
//        Assert.assertEquals(output, "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export interface RawClass {\n" +
//                "        member: string;\n" +
//                "    }\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export type ClassValueNormalTestClass = cz.habarta.typescript.generator.jsonvalue.InterfaceTest.RawClass;\n" +
//                "\n" +
//                "}\n");
//    }
//    @Test
//    public void classValuePrimitiveTest() {
//        final Settings settings = TestUtils.settings();
//        settings.mapPackagesToNamespaces = true;
//        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassValuePrimitiveTestClass.class));
//        Assert.assertEquals(output, "\n" +
//                "declare namespace cz.habarta.typescript.generator.jsonvalue.InterfaceTest {\n" +
//                "\n" +
//                "    export type ClassValuePrimitiveTestClass = string;\n" +
//                "\n" +
//                "}\n");
//    }
//
//    class RawClass {
//        public String member = "asdf";
//    }
//
//    class ClassValueGenericNotValueTestClass {
//        public List<RawClass> test;
//    }
//
//    class ClassValueGenericTestClass {
//        @JsonValue
//        public List<RawClass> test;
//    }
//
//    class ClassValueNormalTestClass {
//        @JsonValue
//        public RawClass test;
//    }
//
//    class ClassValuePrimitiveTestClass {
//        @JsonValue
//        public String test;
//    }
//}
