package com.capstone.trend.controller;

import com.capstone.trend.Navernews;
import com.capstone.trend.YoutubeAPI;
import com.capstone.trend.domain.*;
import com.capstone.trend.dto.FormDTO;
import com.capstone.trend.dto.NavernewsDTO;
import com.capstone.trend.dto.YoutubeDTO;
import com.capstone.trend.repository.*;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
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

    @GetMapping("/news_search")
    public String news_search(Model model){

        model.addAttribute("query",new FormDTO());

        return "news_search";
    }


    @PostMapping("/news_result")
    public String news_result(@ModelAttribute(value = "query") FormDTO formDTO, Model model){
        List<NavernewsDTO> navernewsDTOList = new ArrayList<>();

        JSONArray items = Navernews.getJson(formDTO.getKeyword());

        for (int i = 0; i<items.length(); i++){

            NavernewsDTO navernewsDTO = new NavernewsDTO();
            JSONObject obj = items.getJSONObject(i);
            String title = obj.getString("title");
            String link = obj.getString("link");

            navernewsDTO.setTitle(title);
            navernewsDTO.setLink(link);

            navernewsDTOList.add(navernewsDTO);

            System.out.println(title);
            System.out.println(link);
        }

        model.addAttribute("news",navernewsDTOList);

        return "news_result";
    }



    @GetMapping("/youtube_search")
    public String getSearch(@ModelAttribute(value = "query") FormDTO formDTO){

        return "youtube_search";
    }

    @PostMapping("/youtube_result")
    public String youtuberesult(@ModelAttribute("query") FormDTO formDTO, Model model){

        String kw =formDTO.getKeyword();

        Iterator<SearchResult> searchResultIterator = YoutubeAPI.getVideoId(kw);
        List<YoutubeDTO> youtubeDTOList = new ArrayList<>();

        while(searchResultIterator.hasNext()){

            YoutubeDTO youtubeDTO = new YoutubeDTO();
            youtubeDTO.setKeyword(kw);
            SearchResult singleVideo = searchResultIterator.next();
            ResourceId rId = singleVideo.getId();
            youtubeDTO.setVideoId(rId.getVideoId());
            youtubeDTO.setTitle(singleVideo.getSnippet().getTitle());
            Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
            youtubeDTO.setThumbnailPath(thumbnail.getUrl());

            youtubeDTOList.add(youtubeDTO);
        }

        model.addAttribute("youtubes", youtubeDTOList);


        return "youtube_result";
    }

    @GetMapping("/IPC")
    public String testing(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                          @RequestParam(value = "ipcCode", required = false, defaultValue = "") String ipcCode, Model model){

        List<IPC> ipcList = new ArrayList<>();

        ipcList.addAll(ipcRepository.find_all());
        model.addAttribute("IPC",ipcList);

        List<Keywordcount> keywordcounts= new ArrayList<>();

        System.out.println("ipc code: "+ipcCode);
        System.out.println("keyword: "+keyword);

        if (keyword.isBlank() && ipcCode.isBlank()){
            keywordcounts.addAll(keywordcountReopsitory.find_all());
            model.addAttribute("keyword",keywordcounts);

        }

        else if(!keyword.isBlank() && ipcCode.isBlank() ){
            System.out.println("search by keyword");
            keywordcounts.addAll(keywordcountReopsitory.findByKeyword(keyword));
            model.addAttribute("keyword",keywordcounts);

        }

        else if(keyword.isBlank() && !ipcCode.isBlank()){
            System.out.println("search by ipc code");
            keywordcounts.addAll(keywordcountReopsitory.findByIpcCode(ipcCode));
            model.addAttribute("keyword",keywordcounts);


        }
        else{
            System.out.println("test success");

            keywordcounts.addAll(keywordcountReopsitory.find_all());
            model.addAttribute("keyword",keywordcounts);

        }

        return "testpage";

    }

    @Autowired
    private final OrganizationRepository organizationRepository;
    @GetMapping("/organization")
    public String organization(@RequestParam(value = "ipcCode")String ipcCode,Model model){
        List<Organization> organizations = new ArrayList<>();
        organizations.addAll(organizationRepository.findByCode(ipcCode));
        model.addAttribute("organization", organizations);

        return "testpage2";

    }

    @Autowired
    private final IPCtitleRepository ipCtitleRepository;

    @GetMapping("/ipctitle")
    public String ipctitle(@RequestParam(value = "ipcCode") String ipcCode, Model model){
        List<IPCtitle> ipCtitles = new ArrayList<>();
        ipCtitles.addAll(ipCtitleRepository.findByCode(ipcCode));
        model.addAttribute("ipctitle", ipCtitles);

        return "ipc_title";
    }

    @Autowired
    private final TrendscoreRepository trendscoreRepository;

    @GetMapping("top_trend")
    public String top_trend(Model model){
        List<Trendscore> trendscores = new ArrayList<>();

        trendscores.addAll(trendscoreRepository.find_all());
        model.addAttribute("top_trend", trendscores);

        return "top_trend";
    }
}
