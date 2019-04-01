package com.example.apiexamblog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import java.util.List;

// 네이버 API 예제 - 블로그 이미지 첨부 글쓰기 - Multipart
public class APIExamBlogPostMultipart {

    public static void main(String[] args) {
        String token = "KwLY8ICGvROpjsxz8X6x";//애플리케이션 클라이언트 아이디값";
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            // api url 설정
            String apiURL = "https://openapi.naver.com/blog/writePost.json";
            MultipartUtil mu = new MultipartUtil(apiURL);
            // 접큰 토큰 헤더 추가
            mu.addHeaderField("Authorization", header);
            mu.readyToConnect();
            // blog 글쓰기 필수 요청변수 title 추가
            String title = "네이버 multi-part 이미지 첨부 테스트";
            // blog 글쓰기 필수 요청변수 contents - 첨부이미지는 <img src='#0' />, <img src='#1' /> ... 으로 참조 가능
            String contents = "<font color='red'>multi-part</font>로 첨부한 글입니다. <br>  이미지 첨부 <br> <img src='#0' />";
            mu.addFormField("title", title);
            mu.addFormField("contents", contents);

            // [시작] image 첨부 로직 - 필요시 이미지수 만큼 반복
            File uploadFile1 = new File("YOUR_FILE_NAME_1");
            mu.addFilePart("image", uploadFile1);
            File uploadFile2 = new File("YOUR_FILE_NAME_1");
            mu.addFilePart("image", uploadFile2);
            // [종료] 이미지 첨부 로직 - 필요시 이미지수 만큼 반복

            // HTTP 호출 결과 수신
            List response = mu.finish();
            System.out.println("SERVER REPLIED:");

            for (Object line : response) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
