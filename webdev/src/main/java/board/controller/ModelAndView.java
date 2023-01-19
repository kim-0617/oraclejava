package board.controller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private Map<String, Object> model = new HashMap<String, Object>(); // Model에서 처리한 결과 데이터를 담기 위한
																		// Map
	private String viewName;

	public ModelAndView() {

	}

	public ModelAndView(String viewName) {
		setViewName(viewName);
	}

	public ModelAndView(String viewName, String key, Object obj) {
		setViewName(viewName);
		addObject(key, obj);
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void addObject(String key, Object obj) { // model 맵에 key와 value를 저장하기 위한 메소드
		model.put(key, obj);
	}
}
