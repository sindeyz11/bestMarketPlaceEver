"use client";

// TODO: адаптировать поле ввода под разные экраны

import "@/components/ui/field-no-snippers.css";

interface IField {
  variant?: "default" | "numeric" | "textarea";
  type?: "text" | "email";
  placeholder?: string;
  icon?: React.ReactNode;
  startContent?: string;
  value?: string;
  onChange?: React.ChangeEventHandler<HTMLInputElement | HTMLTextAreaElement>;
}

export const Field = ({
  variant = "default",
  type = "text",
  placeholder,
  icon,
  startContent,
  value,
  onChange,
}: IField) => {
  return (
    <>
      {/* обычное текстовое поле ввода */}
      {variant === "default" && (
        <label className="relative w-full flex items-center">
          {icon && (
            <span className="h-5 w-5 text-black absolute left-3 top-1/2 transform -translate-y-1/2">
              {icon}
            </span>
          )}
          {startContent && (
            <span
              className={`absolute top-1/2 transform -translate-y-1/2 font-medium select-none ${
                icon ? "left-10" : "left-3"
              }`}
            >
              {startContent}
            </span>
          )}
          <input
            type={type}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
            className={`p-2.5 w-full bg-field-bg rounded-lg outline-none focus:bg-field-bg/80 transition-colors text-sm placeholder:text-sm placeholder:text-secondary-text text-black border border-transparent ${
              icon && !startContent ? "pl-11" : ""
            } ${startContent ? (icon ? "pl-[4.3rem]" : "pl-8") : ""}`}
          />
        </label>
      )}
      {/* числовой ввод */}
      {variant === "numeric" && (
        <label className="relative w-28">
          {startContent && (
            <span className="absolute top-1/2 transform -translate-y-1/2 left-3">
              {startContent}
            </span>
          )}
          <input
            type="number"
            placeholder={placeholder}
            className={`p-3 border border-black rounded-lg outline-none w-full ${
              startContent && "pl-8"
            }`}
          />
        </label>
      )}
      {/* расширенное текстовое поле ввода */}
      {variant === "textarea" && (
        <textarea
          className="outline-none rounded-lg bg-white p-3"
          placeholder={placeholder}
        />
      )}
    </>
  );
};
