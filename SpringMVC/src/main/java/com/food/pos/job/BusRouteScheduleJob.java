///*
// * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
// */
//
//package com.food.pos.job;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
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
//import com.iisi.base.dao.RouteDAO;
//import com.iisi.base.entity.BusRoutePO;
//
///**
// * 更新公車路線排程<br>
// * 執行週期：每天晚上12點
// * 
// * @author yichen
// */
//@Component
//public class BusRouteScheduleJob extends AbstractScheduledJobBean<Object> {
//
//    // ================================================
//    // == [Enumeration types] Block Start
//    // ====
//    // ====
//    // == [Enumeration types] Block End
//    // ================================================
//    // == [Static variables] Block Start
//    // ====
//    private static final Logger LOG = LoggerFactory.getLogger(BusRouteScheduleJob.class);
//
//    @Autowired
//    private RouteDAO routeDAO;
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
//    public BusRouteScheduleJob() {
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
//    // @Scheduled(cron = "0 0 0 * * ?")
//    public final String doWork() {
//        LOG.info("開始執行更新公車路線排程");
//        Date start = new Date();
//        String url = "http://citybus.taichung.gov.tw/xmlbus2/StaticData/GetRoute.xml";
//        try {
//            SAXBuilder buider = new SAXBuilder();
//            Document document = buider.build(new URL(url));
//            Element root = document.getRootElement();
//
//            List<Element> data = root.getChild("BusInfo").getChildren("Route");
//            List<BusRoutePO> list = new ArrayList<BusRoutePO>();
//            for (int i = 0; i < data.size(); i++) {
//                Element temp = data.get(i);
//                BusRoutePO dto = new BusRoutePO();
//
//                dto.setId(StringUtils.leftPad((i + 1) + "", 3, "0"));
//                dto.setRouteId(temp.getAttributeValue("ID"));
//                dto.setProviderId(temp.getAttributeValue("ProviderId"));
//                dto.setName(temp.getAttributeValue("nameZh"));
//                dto.setDepartureName(temp.getAttributeValue("departureZh"));
//                dto.setDestinationName(temp.getAttributeValue("destinationZh"));
//                dto.setRemark(temp.getAttributeValue("ddesc"));
//
//                list.add(dto);
//            }
//
//            this.routeDAO.updateAllRoute(list);
//
//        } catch (Exception e) {
//            LOG.error("更新公車路線排程有錯", e);
//        }
//
//        LOG.info("更新公車路線排程執行了: " + (System.currentTimeMillis() - start.getTime()) + " ms");
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
