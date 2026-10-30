import katex from "katex";
import "katex/dist/katex.min.css";
import "../../App.css";
import { useEffect, useRef } from "react";
const KatexLabel = ({ latex }) => {
  const ref = useRef(null);
  useEffect(() => {
    katex.render(latex, ref.current, {
      throwOnError: false,
    });
  }, [latex]);
  return <span ref={ref} className="katexLabel"></span>;
};
export default KatexLabel;
