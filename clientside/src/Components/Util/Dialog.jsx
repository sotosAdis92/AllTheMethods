import { forwardRef } from "react";

const Dialog = forwardRef(
  ({ props, openConfirmationBox, handleDelete }, ref) => {
    return (
      <div>
        <dialog
          ref={ref}
          onClick={(e) => {
            if (e.currentTarget === e.target) {
              openConfirmationBox();
            }
          }}
        >
          {props}
          <button onClick={handleDelete}>Delete</button>
          <button onClick={openConfirmationBox}>Close</button>
        </dialog>
      </div>
    );
  },
);
export default Dialog;
