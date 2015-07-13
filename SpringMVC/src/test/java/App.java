import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.pos.dto.QueryBillReporDTO;
import com.food.pos.util.report.IReportComnent;
import com.food.pos.util.report.IReprtParmeter.Report;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"mvc-dispatcher-servlet.xml");
		IReportComnent dao = (IReportComnent) ac.getBean(IReportComnent.class);
		QueryBillReporDTO dto = new QueryBillReporDTO();

		final Map<String, Object> title = new HashMap<String, Object>();

		final List<Map<String, String>> contentData = new ArrayList<Map<String, String>>();

		title.put("title", "XXX");
		dto.set(Report.R001, title, contentData);
		dao.report(dto);

	}
}
