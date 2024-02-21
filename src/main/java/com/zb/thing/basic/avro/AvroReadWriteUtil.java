package com.zb.thing.basic.avro;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AvroReadWriteUtil {

    public static <T extends SpecificRecordBase> void writeAvroToFile(T avroObject, String fileName) {
        DatumWriter<T> writer = new SpecificDatumWriter<>(avroObject.getSchema());
        DataFileWriter<T> fileWriter = new DataFileWriter<>(writer);
        try {
            if (Files.notExists(new File(fileName).toPath())) {
                Files.createDirectories(new File(fileName).toPath().getParent());
            }

            fileWriter.create(avroObject.getSchema(), new File(fileName));
            fileWriter.append(avroObject);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends SpecificRecordBase> T readFromAvro(Class<T> avroClass, String path) throws IOException {
        DatumReader<T> datumReader = new SpecificDatumReader<>(avroClass);
        DataFileReader<T> dataFileReader = new DataFileReader<>(new File(path), datumReader);
        T avroObject = null;
        if (dataFileReader.hasNext()) {
            avroObject = dataFileReader.next();
        }
        dataFileReader.close();
        return avroObject;
    }
}
