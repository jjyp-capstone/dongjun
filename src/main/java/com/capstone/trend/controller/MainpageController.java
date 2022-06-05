package com.capstone.trend.controller;

import com.capstone.trend.Crawl;
import com.capstone.trend.YoutubeAPI;
import com.capstone.trend.dto.MainpageDTO;
import com.capstone.trend.dto.YoutubeDTO;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import com.google.api.services.youtube.model.ThumbnailDetails;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainpageController {
    @GetMapping("/main")
    public String getSearch(Model model){
        ArrayList<YoutubeDTO> youtubeDTOS = new ArrayList<>();
        model.addAttribute("youtube", youtubeDTOS);

        return "mainpage";
    }

    @PostMapping("/result")
    public String newsresult(@ModelAttribute("mainpage") MainpageDTO mainpageDTO){
        List<String> crawl_result = Crawl.main(mainpageDTO.getKeyword());
        mainpageDTO.setNewsURL(crawl_result.get(0));
        mainpageDTO.setNewstitle(crawl_result.get(1));

        return "newsresult";
    }

    @PostMapping("/result2")
    public String youtuberesult(@ModelAttribute("youtube") ArrayList<YoutubeDTO> youtubeDTOS){
        Iterator<SearchResult> youtube_list= YoutubeAPI.getVideoId(youtubeDTOS.get(0).getKeyword());



        while(youtube_list.hasNext()){

            YoutubeDTO youtubeDTO = new YoutubeDTO();

            SearchResult singleVideo = youtube_list.next();
            ResourceId rId = singleVideo.getId();
            Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();

            youtubeDTO.setThumbnailPath(thumbnail.getUrl());
            youtubeDTO.setVideoId(rId.getVideoId());
            youtubeDTO.setTitle(singleVideo.getSnippet().getTitle());

            youtubeDTOS.add(youtubeDTO);
        }


        return "youtuberesult";
    }
}
