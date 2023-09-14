package com.elyashevich.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {

    private String id;

    private String name;

    @TextIndexed
    private String type;

    private byte[] picByte;
}
