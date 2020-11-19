package cz.habarta.typescript.generator.jsonvalue;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import cz.habarta.typescript.generator.Input;
import cz.habarta.typescript.generator.Settings;
import cz.habarta.typescript.generator.TestUtils;
import cz.habarta.typescript.generator.TypeScriptGenerator;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SubTypeTest {


    @Test
    public void baseTest() {
        final Settings settings = TestUtils.settings();
        settings.mapPackagesToNamespaces = true;
        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(Base.class));
        Assert.assertEquals(output, "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Base {\n" +
                "        type: \"Derived1\" | \"Derived2\";\n" +
                "        sn: number;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived1 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived1\";\n" +
                "        derived1Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived2 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived2\";\n" +
                "        derived2Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export type BaseUnion = cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived1 | cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived2;\n" +
                "\n" +
                "}\n");
    }

    @Test
    public void classValueGenericTest() {
        final Settings settings = TestUtils.settings();
        settings.mapPackagesToNamespaces = true;
        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(ValueWrapper.class));
        Assert.assertEquals(output, "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface ValueWrapper {\n" +
                "        value: cz.habarta.typescript.generator.jsonvalue.SubTypeTest.SubTypeValue;\n" +
                "        notValue: cz.habarta.typescript.generator.jsonvalue.SubTypeTest.SubTypeNotValue;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface SubTypeNotValue {\n" +
                "        test: cz.habarta.typescript.generator.jsonvalue.SubTypeTest.BaseUnion[];\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Base {\n" +
                "        type: \"Derived1\" | \"Derived2\";\n" +
                "        sn: number;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived1 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived1\";\n" +
                "        derived1Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived2 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived2\";\n" +
                "        derived2Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export type SubTypeValue = cz.habarta.typescript.generator.jsonvalue.SubTypeTest.BaseUnion[];\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export type BaseUnion = cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived1 | cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived2;\n" +
                "\n" +
                "}\n");
    }


    @Test
    public void classValueGenericTest2() {
        final Settings settings = TestUtils.settings();
        settings.mapPackagesToNamespaces = true;
        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(SubTypeValue.class));
        Assert.assertEquals(output, "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Base {\n" +
                "        type: \"Derived1\" | \"Derived2\";\n" +
                "        sn: number;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived1 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived1\";\n" +
                "        derived1Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export interface Derived2 extends cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Base {\n" +
                "        type: \"Derived2\";\n" +
                "        derived2Member: string;\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export type SubTypeValue = cz.habarta.typescript.generator.jsonvalue.SubTypeTest.BaseUnion[];\n" +
                "\n" +
                "}\n" +
                "\n" +
                "declare namespace cz.habarta.typescript.generator.jsonvalue.SubTypeTest {\n" +
                "\n" +
                "    export type BaseUnion = cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived1 | cz.habarta.typescript.generator.jsonvalue.SubTypeTest.Derived2;\n" +
                "\n" +
                "}\n");
    }

    @Test
    public void testPrint() throws JsonProcessingException {
        Assert.assertEquals("{\"test\":[{\"type\":\"Derived1\",\"sn\":null,\"derived1Member\":\"a\"}]}", new JsonMapper().writeValueAsString(new SubTypeNotValue()));
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "type",
            include = JsonTypeInfo.As.EXISTING_PROPERTY
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Derived1.class, name = "Derived1"),
            @JsonSubTypes.Type(value = Derived2.class, name = "Derived2")
    })
    @JsonPropertyOrder({"type", "sn"})
    abstract class Base {
        public Integer sn;

        public String getType() {
            return getClass().getSimpleName();
        }
    }

    class Derived1 extends Base {
        public String derived1Member = "a";

    }

    class Derived2 extends Base {
        public String derived2Member = "a";
    }

    class SubTypeValue {
        @JsonValue
        private List<Base> test = Arrays.asList(new Derived1());

        public List<Base> getTest() {
            return test;
        }
    }

    class SubTypeNotValue {
        public List<Base> test = Arrays.asList(new Derived1());
    }

    class ValueWrapper {
        public SubTypeValue value;
        public SubTypeNotValue notValue;
    }
}
