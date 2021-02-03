package com.ding.demo.web;

import com.ding.demo.service.MovieRecommender;
import org.apache.commons.lang.StringUtils;
import org.apache.mahout.cf.taste.common.TasteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ding
 * @date 2021/2/2
 */
@RestController @RequestMapping("/commend") public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired private MovieRecommender movieRecommender;

	@GetMapping("/userBase/{id}/{number}") public String getRecommendUserBase(
			@PathVariable("id") Long userId,@PathVariable("number")Integer number) throws TasteException {

		long start = System.currentTimeMillis();
		logger.info("启动时间:{}",start);
		List<Long> movieIds = movieRecommender.userBasedRecommender(userId, number);
		long end = System.currentTimeMillis();
		logger.info("执行时间:{}" ,(start - end));
		return StringUtils.join(movieIds, ",");
	}


	@GetMapping("/itemBase/{id}") public String getRecommendItemBase(
			@PathVariable("id") Long userId) throws TasteException {
		long start = System.currentTimeMillis();
		logger.info("启动时间:{}",start);
		List<Long> movieIds = movieRecommender.itemBasedRecommender(userId, 20);
		long end = System.currentTimeMillis();
		logger.info("执行时间:{}" ,(start - end));
		return StringUtils.join(movieIds, ",");
	}
















}
