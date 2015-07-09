import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.pos.dao.BillDAO;
import com.food.pos.domain.BillPo;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"mvc-dispatcher-servlet.xml");
		BillDAO dao = (BillDAO) ac.getBean(BillDAO.class);
		List<BillPo> pos = dao.findAll(BillPo.class);

		HashMap parameters = new HashMap();
		parameters.put("source", pos);

		File f = new File("/POS/tmp");
		System.out.print(f.getAbsolutePath());

	}
}
