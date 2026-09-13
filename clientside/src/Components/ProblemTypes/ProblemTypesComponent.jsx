const ProblemCategoriesComponent = ({ problemTypes }) => {
  return (
    <div className="problemTypeContainer">
      <div className="problemType">
        {problemTypes.map((problemTypes) => (
          <div>{problemTypes}</div>
        ))}
      </div>
    </div>
  );
};
export default ProblemCategoriesComponent;
