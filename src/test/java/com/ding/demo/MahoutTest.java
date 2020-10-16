package com.ding.demo;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.util.List;

/**
 * @author ding
 * @date 2020/10/16
 */
public class MahoutTest {

	public static void main(String[] args) throws Exception {
		FileDataModel fileDataModel = new FileDataModel(new File("D://2.txt"));

//		itemRecommend(2L,fileDataModel);
		userRecommend(2L,fileDataModel);

	}

	static void itemRecommend(Long userId,FileDataModel fileDataModel) {
		try {
			PearsonCorrelationSimilarity pearsonCorrelationSimilarity = new PearsonCorrelationSimilarity(
					fileDataModel);

			Recommender recommender = new GenericItemBasedRecommender(
					fileDataModel, pearsonCorrelationSimilarity);

			List<RecommendedItem> recommend = recommender.recommend(userId, 10);

			for (RecommendedItem recommendedItem : recommend) {
				System.out.println(recommendedItem.getItemID());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void userRecommend(Long userId,FileDataModel model) {
		try {

			PearsonCorrelationSimilarity similarity = new PearsonCorrelationSimilarity(
					model);
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(3,
					similarity, model);

			Recommender recommender = new CachingRecommender(
					new GenericUserBasedRecommender(model, neighborhood,
							similarity));

			List<RecommendedItem> recommend = recommender.recommend(userId, 1);

			for (RecommendedItem recommendedItem : recommend) {
				System.out.println(recommendedItem.getItemID());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
