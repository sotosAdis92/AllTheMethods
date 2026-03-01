import { useState } from "react";
const AchievementFilters = () => {
  const [selectedFilters, setSelectedFilters] = useState([]);
  const [filteredItems, setFilteredItems] = useState();
  let filters = [
    "Polynomial Roots",
    "Integrals",
    "Intrapolation",
    "Derivatives",
    "Differential Equations",
    "Linear Systems",
  ];
  const handleFilterButtonClick = (selectedCategory) => {
    if (selectedFilters.includes(selectedCategory)) {
      let filters = selectedFilters.filter((el) => el !== selectedCategory);
      selectedCategory(filters);
    } else {
      selectedFilters([...selectedFilters, selectedCategory]);
    }
  };

  return (
    <>
      <div>
        {filter.map((category, i) => (
          <button
            onClick={() => handleFilterButtonClick(category)}
            className={`button ${selectedFilters?.includes(category) ? "active" : ""}`}
            key={`filters-${i}`}
          >
            {category}
          </button>
        ))}
      </div>
      <div></div>
    </>
  );
};
export default AchievementFilters;
