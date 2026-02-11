const ListProblemComponent = () => {
  const dummyData = [
    {
      id: 1,
      number: 1,
      title: "Simpson I",
      category: "Integrals",
      difficulty: "Easy",
      description: "Easy Problem on Integrals",
      points: 15,
    },
    {
      id: 2,
      number: 2,
      title: "Simpson II",
      category: "Integrals",
      difficulty: "Easy",
      description: "Easy Problem on Integrals",
      points: 15,
    },
    {
      id: 3,
      number: 3,
      title: "Simpson III",
      category: "Integrals",
      difficulty: "Easy",
      description: "Easy Problem on Integrals",
      points: 15,
    },
  ];

  const listOfProblems = dummyData.map((problem) => (
    <li key={problem.id}>
      {problem.number}
      {problem.title}
      {problem.difficulty}
    </li>
  ));
  return (
    <div>
      <ol>{listOfProblems}</ol>
    </div>
  );
};

export default ListProblemComponent;
