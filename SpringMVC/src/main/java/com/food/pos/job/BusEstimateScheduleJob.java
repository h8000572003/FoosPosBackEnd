///*
// * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
// */
//
//package com.food.pos.job;
//
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang3.StringUtils;
//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.input.SAXBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.iisi.base.dao.StopDAO;
//import com.iisi.base.entity.BusStopPO;
//
///**
// * 更新公車預估到站資料排程<br>
// * 執行週期：每分鐘
// * 
// * @author yichen
// */
//@Component
//public class BusEstimateScheduleJob extends AbstractScheduledJobBean<Object> {
//
//    // ================================================
//    // == [Enumeration types] Block Start
//    // ====
//    // ====
//    // == [Enumeration types] Block End
//    // ================================================
//    // == [Static variables] Block Start
//    // ====
//    private static final Logger LOG = LoggerFactory.getLogger(BusEstimateScheduleJob.class);
//
//    @Autowired
//    private StopDAO stopDAO;
//
//    // ====
//    // == [Static variables] Block End
//    // ================================================
//    // == [Instance variables] Block Start
//    // ====
//    // ====
//    // == [Instance variables] Block End
//    // ================================================
//    // == [Static Constructor] Block Start
//    // ====
//    // ====
//    // == [Static Constructor] Block End
//    // ================================================
//    // == [Constructors] Block Start (含tinit method)
//    // ====
//    public BusEstimateScheduleJob() {
//
//    }
//
//    // ====
//    // == [Constructors] Block End
//    // ================================================
//    // == [Static Method] Block Start
//    // ====
//    // ====
//    // == [Static Method] Block End
//    // ================================================
//    // == [Accessor] Block Start
//    // ====
//    // ====
//    // == [Accessor] Block End
//    // ================================================
//    // == [Overridden Method] Block Start (Ex. toString/equals+hashCode)
//    // ====
//    @Override
//    // @PostConstruct
//    // @Scheduled(cron="0 * * * * ?")
//    public final String doWork() {
//        LOG.info("開始執行更新公車預估到站資料排程");
//        Date start = new Date();
//        String url = "http://citybus.taichung.gov.tw/xmlbus2/GetEstimateTime.xml";
//        Map<String, List<BusStopPO>> routeMap = new HashMap<String, List<BusStopPO>>();
//        try {
//            URLConnection urlConnection = new URL(url).openConnection();
//            urlConnection.setConnectTimeout(30000);
//            urlConnection.setReadTimeout(50000);
//
//            SAXBuilder buider = new SAXBuilder();
//            Document document = buider.build(urlConnection.getInputStream());
//            Element root = document.getRootElement();
//
//            List<Element> routes = root.getChild("BusInfo").getChildren("Route");
//            for (int i = 0; i < routes.size(); i++) {
//                Element route = routes.get(i);
//                String routeId = route.getAttributeValue("Id");
//
//                List<Element> data = route.getChildren("EstimateTime");
//                List<BusStopPO> list = new ArrayList<BusStopPO>();
//                for (int j = 0; j < data.size(); j++) {
//                    Element temp = data.get(j);
//                    BusStopPO dto = new BusStopPO();
//
//                    dto.setId(temp.getAttributeValue((j + 1) + ""));
//                    dto.setStopId(temp.getAttributeValue("StopID"));
//                    dto.setRouteId(routeId);
//                    dto.setName(temp.getAttributeValue("StopName"));
//                    dto.setArrivalTime(temp.getAttributeValue("comeTime"));
//                    dto.setSeqNo(StringUtils.leftPad(temp.getAttributeValue("seqNo"), 3, "0"));
//                    dto.setGoBack(temp.getAttributeValue("GoBack"));
//
//                    list.add(dto);
//                }
//
//                routeMap.put(routeId, list);
//            }
//            this.stopDAO.putStops(routeMap);
//        } catch (Exception e) {
//            LOG.error("更新公車預估到站資料排程有錯", e);
//        }
//
//        LOG.info("更新公車預估到站資料排程執行了: " + (System.currentTimeMillis() - start.getTime()) + " ms");
//        return "Schedulling Job started successfully";
//    }
//    // ====
//    // == [Overridden Method] Block End
//    // ================================================
//    // == [Method] Block Start
//    // ====
//    // ####################################################################
//    // ## [Method] sub-block :
//    // ####################################################################
//    // ====
//    // == [Method] Block End
//    // ================================================
//}
