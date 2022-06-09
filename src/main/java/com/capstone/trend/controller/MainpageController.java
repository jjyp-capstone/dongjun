package com.capstone.trend.controller;

import com.capstone.trend.Crawl;
import com.capstone.trend.YoutubeAPI;
import com.capstone.trend.domain.IPC;
import com.capstone.trend.domain.Keywordcount;
import com.capstone.trend.dto.MainpageDTO;
import com.capstone.trend.dto.YoutubeDTO;
import com.capstone.trend.repository.IPCRepository;
import com.capstone.trend.repository.KeywordcountReopsitory;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class MainpageController {
    @Autowired
    private final IPCRepository ipcRepository;

    @Autowired
    private final KeywordcountReopsitory keywordcountReopsitory;

    @GetMapping("/main")
    public String getSearch(Model model){


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

    @GetMapping("/IPC")
    public String testing(Model model){

        List<IPC> ipcList = new ArrayList<>();
        ipcList.addAll(ipcRepository.find_all());
        model.addAttribute("IPC",ipcList);

        List<Keywordcount> keywordcounts= new ArrayList<>();
        keywordcounts.addAll(keywordcountReopsitory.find_all());

        model.addAttribute("keyword",keywordcounts);

        return "testpage";

    }
}
