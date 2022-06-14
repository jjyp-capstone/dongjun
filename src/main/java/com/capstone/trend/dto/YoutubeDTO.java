package com.capstone.trend.dto;

import com.google.api.services.youtube.model.Thumbnail;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor

public class YoutubeDTO {
    private String keyword;
    private String title;
    private String thumbnailPath;
    private String videoId;
}
