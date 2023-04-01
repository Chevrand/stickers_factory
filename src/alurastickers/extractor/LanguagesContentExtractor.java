package alurastickers.extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alurastickers.model.Content;
import alurastickers.model.LanguagesContent;
import alurastickers.parser.JsonParser;

public class LanguagesContentExtractor implements ContentExtractor {

	@Override
	public List<Content> extractContent(String json) {
		// Extração dos dados
		JsonParser jsonParser = new JsonParser();
		List<Map<String, String>> dataList = jsonParser.parse(json);

		// Preenchimento da lista de conteúdos com os dados extraídos
		List<Content> contentList = new ArrayList<>();
		dataList.forEach(item -> {
			String title = item.get("title");
			String urlImage = item.get("urlImage");
			LanguagesContent content = new LanguagesContent(title, urlImage);

			contentList.add(content);
		});

		return contentList;
	}

}
