import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.CommonFunction;
import Model.ContactData;
import Model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generationContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generationContacts() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData()
                    .withFistName(CommonFunction.randomString(i * 10))
                    .withLastName(CommonFunction.randomString(i * 10))
                    .withAddress(CommonFunction.randomString(i * 10))
                    .withPhoto(CommonFunction.randomFile("src/test/resources/images"))
                    .withNickName(CommonFunction.randomString(i * 10))
                    .withMiddleName(CommonFunction.randomString(i * 10))
                    .withEmail(CommonFunction.randomString(i * 10))
                    .withPhonesHome(CommonFunction.randomString(i * 10)));
        }
        return result;
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunction.randomString(i * 10))
                    .withHeader(CommonFunction.randomString(i * 10))
                    .withFooter(CommonFunction.randomString(i * 10)));
        }
        return result;

    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            var mapper = new JsonMapper();
            mapper.writeValue(new File(output), data);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output)) {
                writer.write(json);
            }
        } else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
            var yaml = mapper.writeValueAsString(data);
            try (var writer = new FileWriter(output)) {
                writer.write(yaml);
            }
        } else if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
            var xml = mapper.writeValueAsString(data);
            try (var writer = new FileWriter(output)) {
                writer.write(xml);
            }
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных" + format);
        }
    }
}