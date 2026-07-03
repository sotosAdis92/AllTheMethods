import katex from "katex";
import { useEffect, useRef } from "react";
export default function KatexLabel({ latex }) {
  const ref = useRef(null);
  useEffect(() => {
    katex.render(latex, ref.current, {
      throwOnError: false,
      displayMode: false,
    });
  }, [latex]);
  return <span ref={ref}></span>;
}
