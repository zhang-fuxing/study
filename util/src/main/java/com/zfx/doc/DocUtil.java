package com.zfx.doc;

import cn.hutool.core.codec.Base64;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.extra.template.engine.freemarker.FreemarkerEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author zhangfx
 * @date 2023/3/7
 */
public class DocUtil {
	
	public static void main(String[] args) throws Exception {
		TemplateConfig config = new TemplateConfig();
		config.setCustomEngine(FreemarkerEngine.class);
		config.setCharset(StandardCharsets.UTF_8);
		config.setResourceMode(TemplateConfig.ResourceMode.CLASSPATH);
		config.setPath("/template");
		TemplateEngine engine = TemplateUtil.createEngine(config);
		var template = engine.getTemplate("/createDoc.ftl");
		
		DocData docData = new DocData();
		docData.setProjectName("this is projectName");
		docData.setWorkPlan("work plan is ......");
		docData.setCapital("90w");
		docData.setCapitalSource("tz");
		docData.setYears("2023");
		docData.setMonth("6");
		docData.setData("FreeMarker 是 免费的， 基于Apache许可证2.0版本发布。\n" +
				"\n" +
				"如果你发现 任何错误 (包括 语法错误, 错别字, 排版错误) 或者是在文档中找到 误导或混淆 ，或有其他建议，请联系原作者! Email: ddekany at users.sourceforge.net\n" +
				"\n" +
				"文档翻译的任何问题（包括语法错误，错别字）或中文技术交流，可以联系译者：nanlei1987 at gmail.com， 或在FreeMarker的Github上Fork一份，修改之后提交Pull Request。我们共同研究，共同进步。\n" +
				"\n" +
				"英文版文档的作者(也是FreeMarker项目的维护者)是匈牙利人，其母语非英语，那么在这种情况下， 翻译过程难免会有错误存在，译者结合自身多年对FreeMarker的实践力争精准，译文力求信达雅。 但因个人才疏学浅，水平有限，恳请广大读者批评指正。最好的方式就是使用Github了");
		docData.setConsUnit("xxxx单位");
		docData.setImg(new DocImg("1", "jpg", Base64.encode(new File("D:/file/2159314WsId.jpg"))));
		docData.setSignYears("2023");
		docData.setSignMonth("07");
		docData.setSignDay("22");
		
		
		DocImg docImg = new DocImg("1", "jpg", Base64.encode(new File("D:/file/2159314WsId.jpg")));
		
		DynamicTable table = new DynamicTable();
		table.setApproval("mmm单位审核意见：");
		table.setApprovalContent("是被用来在MVC模式的Web开发框架中生成HTML页面的，它没有被绑定到 Servlet或HTML或任意Web相关的东西上。它也可以用于非Web应用环境中.");
		table.setImg(docImg);
		table.setYear("2023");
		table.setMonth("07");
		table.setDay("26");
		
		
		template.render(
				Map.of("images", List.of(docImg),
						"content", docData,
						"table", List.of(table)),
				new FileWriter("D:/imgTmp.doc"));
	}
	
	public static void generateWord(Map<String, Object> dataMap, String templateName, String fileName) throws Exception {
		
		// 设置FreeMarker的版本和编码格式
		Configuration configuration = new Configuration(new Version("2.3.28"));
		configuration.setDefaultEncoding("UTF-8");
		
		// 设置FreeMarker生成Word文档所需要的模板的路径
		// configuration.setDirectoryForTemplateLoading(new File("/Users/xxx/Desktop/"));
		// 此处把word转成的ftl模版文件都放在 resources 下的 templates文件夹中
		configuration.setClassForTemplateLoading(DocUtil.class, "/template");
		
		// 设置FreeMarker生成Word文档所需要的模板
		Template tem = configuration.getTemplate(templateName, "UTF-8");
		// 创建一个Word文档的输出流
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));
		// FreeMarker使用Word模板和数据生成Word文档
		tem.process(dataMap, out);
		out.flush();
		out.close();
	}
	
	
}
