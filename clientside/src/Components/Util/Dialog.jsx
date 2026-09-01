import { forwardRef } from "react";
import "./Dialog.css";
const Dialog = forwardRef(
  ({ children, openConfirmationBox, handleDelete }, ref) => {
    return (
      <div>
        <dialog
          className="dialogContainer"
          ref={ref}
          onClick={(e) => {
            if (e.currentTarget === e.target) {
              openConfirmationBox();
            }
          }}
        >
          {children}
          <div className="buttonsDiv">
            <button onClick={handleDelete} className="deletionButton">
              Delete
            </button>
            <button
              onClick={openConfirmationBox}
              className="cancellationButton"
            >
              Close
            </button>
          </div>
        </dialog>
      </div>
    );
  },
);
export default Dialog;
