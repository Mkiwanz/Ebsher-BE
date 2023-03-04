package project.ebsher.Entity.Helpers;

import java.io.*;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MultipartFileDeserializer extends JsonDeserializer<MultipartFile> {

    @Override
    public MultipartFile deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectCodec codec = parser.getCodec();
        String base64String = codec.readValue(parser, String.class);
        byte[] bytes = Base64.getDecoder().decode(base64String);
        String filename = "file";
        return new ByteArrayMultipartFile(bytes, filename);
    }

    private static class ByteArrayMultipartFile implements MultipartFile {
        private final byte[] bytes;
        private final String filename;

        public ByteArrayMultipartFile(byte[] bytes, String filename) {
            this.bytes = bytes;
            this.filename = filename;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getOriginalFilename() {
            return this.filename;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return this.bytes == null || this.bytes.length == 0;
        }

        @Override
        public long getSize() {
            return this.bytes.length;
        }

        @Override
        public byte[] getBytes() throws IOException {
            return this.bytes;
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(this.bytes);
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {
            new FileOutputStream(dest).write(this.bytes);
        }
    }

}
