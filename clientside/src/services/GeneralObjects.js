import {
  sendDiakritiNewtonRaphsonData,
  sendNewtonRaphsonData,
  sendRegulaFalsiData,
  sendSimposonData,
  sendSubmissionData,
  sendThreePointDerivativeData,
  sendTrapezodialData,
} from "./SubmitService";

export const problemObjectsConfig = {
  Bisection: {
    type: "Polynomial-Roots",
    submitFunction: (data) => sendSubmissionData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      problemSpaceA: state.problemSpaceA,
      problemSpaceB: state.problemSpaceB,
    }),
    displayStats: (state) => ({
      labelIterations: `For: ${state.iterations} iterations`,
      labelSpace: `In the space [${state.problemSpaceA},${state.problemSpaceB}]`,
    }),
  },

  "Regula-Falsi": {
    type: "Polynomial-Roots",
    submitFunction: (data) => sendRegulaFalsiData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      problemSpaceA: state.problemSpaceA,
      problemSpaceB: state.problemSpaceB,
    }),
    displayStats: (state) => ({
      labelIterations: `For: ${state.iterations} iterations`,
      labelSpace: `In the space [${state.problemSpaceA},${state.problemSpaceB}]`,
    }),
  },

  "Newton-Raphson": {
    type: "Polynomial-Roots",
    submitFunction: (data) => sendNewtonRaphsonData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      xZero: state.xo,
    }),
    displayStats: (state) => ({
      labelIterations: `For: ${state.iterations} iterations`,
      labelXo: `With an Xo=${state.xZero}`,
    }),
  },

  "Diakriti-Newton-Raphson": {
    type: "Polynomial-Roots",
    submitFunction: (data) => sendDiakritiNewtonRaphsonData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      xZero: state.xo,
      hparameter: state.hparameter,
    }),
    displayStats: (state) => ({
      labelIterations: `For: ${state.iterations} iterations`,
      labelXo: `With an Xo=${state.xZero}`,
      labelHparameter: `With an H=${state.hparameter}`,
    }),
  },

  "Trapezodial-Rule": {
    type: "Integrals",
    submitFunction: (data) => sendTrapezodialData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      integrationPointA: state.integrationPointA,
      integrationPointB: state.integrationPointB,
      hparameter: state.hparameter,
    }),
    displayStats: (state) => ({
      labelSpace: `In the space [${state.integrationPointA},${state.integrationPointB}]`,
    }),
  },

  "Simpson-Rule": {
    type: "Integrals",
    submitFunction: (data) => sendSimposonData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      integrationPointA: state.integrationPointA,
      integrationPointB: state.integrationPointB,
      hparameter: state.hparameter,
    }),
    displayStats: (state) => ({
      labelIterations: `For: $(state.iterations) iterations`,
      labelSpace: `In the space [${state.problemSpaceA},${state.problemSpaceB}]`,
    }),
  },

  "Three-Point-Derivative": {
    type: "Derivative",
    submitFunction: (data) => sendThreePointDerivativeData(data),
    getSubmissionData: (state, props) => ({
      inp: state.inp,
      problemMethod: props.problemMethod,
      problemString: props.problemString,
      iterations: state.iterations,
      problemSpaceA: state.problemSpaceA,
      problemSpaceB: state.problemSpaceB,
    }),
    displayStats: (state) => ({
      labelIterations: `For: $(state.iterations) iterations`,
      labelSpace: `In the space [${state.problemSpaceA},${state.problemSpaceB}]`,
    }),
  },
};
