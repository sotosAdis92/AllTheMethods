import { useEffect, useState } from "react";
import { getAchievementsByCategory } from "../services/AchievementService";

export default function useFetchRelatedAchievements(props) {
  const [achievements, setAchievements] = useState([]);

  //Fetching related Achievements
  useEffect(() => {
    getAchievementsByCategory(props.problemCategory)
      .then((response) => {
        console.log(response.data);
        const fetchedData = [];
        for (let i = 0; i < response.data.length; i++) {
          const achievement = response.data[i];
          fetchedData.push(achievement);
        }
        setAchievements(fetchedData);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [props.problemCategory]);

  return { achievements };
}
