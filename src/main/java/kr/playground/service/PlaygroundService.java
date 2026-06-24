package kr.playground.service;

import org.springframework.stereotype.Service;

@Service("playgroundService")
public class PlaygroundService {
	
	public String getMessage() {
		return "Service에서 만든 메시지!";
	}
	
	public int getCount() {
		return 42 + 1; // 로직은 service에
	}
}
