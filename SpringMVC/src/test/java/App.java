import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.pos.bean.QueryBillReportBean;
import com.food.pos.dto.QueryBillReporDTO;
import com.food.pos.util.report.IReportComnent;
import com.food.pos.util.report.IReprtParmeter.Report;

public class App {

	private static Logger LOG = LoggerFactory
			.getLogger(QueryBillReportBean.class);

	public static void main(String[] args) {
		File fo = new File("/POS/tmp/xxx.txt");

		LOG.info("AbsolutePath={}", fo.getAbsolutePath());

		LOG.info("info={}", fo.getPath());
	}
}
