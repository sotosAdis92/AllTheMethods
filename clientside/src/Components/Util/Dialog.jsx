import { forwardRef } from "react";

const Dialog = forwardRef(
  ({ props, openConfirmationBox, handleDelete }, ref) => {
    return (
      <div>
        <dialog
          ref={dialogRef}
          onClick={(e) => {
            if (e.currentTarget === e.target) {
              openConfirmationBox();
            }
          }}
        >
          {props}
          <button onClick={handleDelete()}>Delete</button>
          <buttton onClick={openConfirmationBox()}>Close</buttton>
        </dialog>
      </div>
    );
  },
);
export default Dialog;
