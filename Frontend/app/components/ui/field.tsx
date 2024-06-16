"use client";

// TODO: адаптировать поле ввода под разные экраны

import "@/components/ui/field-no-snippers.css";
import { useState } from "react";

interface IField {
  variant?: "default" | "numeric" | "textarea" | "card";
  type?: "text" | "email" | "password";
  placeholder?: string;
  icon?: React.ReactNode;
  startContent?: string;
  value?: string;
  name?: string;
  color?: "default" | "white";
  onChange?: React.ChangeEventHandler<HTMLInputElement | HTMLTextAreaElement>;
  disabled?: boolean;
  maxLength?: number;
}

export const Field = ({
  variant = "default",
  type = "text",
  placeholder,
  icon,
  name,
  startContent,
  value,
  onChange,
  color,
  disabled,
  maxLength,
}: IField) => {
  const [cardNumber, setCardNumber] = useState("1010101010101010");

  const handleCardNumberChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    let value = e.target.value.replace(/\D/g, "");
    if (value.length > 16) {
      value = value.slice(0, 16);
    }
    let formattedValue = value.replace(/(.{4})/g, "$1 ").trim();
    setCardNumber(formattedValue);
    if (onChange) {
      const event = { ...e, target: { ...e.target, value: formattedValue } };
      onChange(event);
    }
  };

  return (
    <>
      {variant === "default" && (
        <label className="relative w-full flex items-center">
          {icon && (
            <span className="h-5 w-5 text-black absolute left-3 top-1/2 transform -translate-y-[55%] flex items-center">
              {icon}
            </span>
          )}
          {startContent && (
            <span
              className={`absolute top-1/2 transform -translate-y-1/2 font-medium select-none text-sm flex items-center ${
                icon ? "left-10" : "left-3"
              }`}
            >
              {startContent}
            </span>
          )}
          <input
            name={name}
            disabled={disabled}
            type={type}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
            maxLength={maxLength}
            className={`p-3 w-full bg-field-bg flex items-center ${
              color === "white" && "bg-white focus:bg-white/60"
            } rounded-lg outline-none focus:bg-field-bg/80 transition-colors text-sm placeholder:text-sm placeholder:text-secondary-text text-black border border-transparent ${
              disabled && "text-center cursor-not-allowed"
            } ${
              startContent
                ? icon
                  ? "pl-[calc(2.5rem+1.2rem)]"
                  : "pl-[calc(2.5rem+1rem)]"
                : icon
                  ? "pl-11"
                  : ""
            }`}
          />
        </label>
      )}

      {variant === "numeric" && (
        <label className="relative w-28">
          {startContent && (
            <span className="absolute top-1/2 transform -translate-y-1/2 left-3 font-medium">
              {startContent}
            </span>
          )}
          <input
            type="number"
            name={name}
            placeholder={placeholder}
            className={`p-3 border border-black rounded-lg outline-none w-full text-sm placeholder:text-sm placeholder:text-secondary-text ${
              !startContent && "text-center"
            } ${startContent && "pl-8"}`}
          />
        </label>
      )}

      {variant === "textarea" && (
        <textarea
          className="outline-none rounded-lg bg-white p-3 text-sm placeholder:text-sm w-full placeholder:text-secondary-text"
          placeholder={placeholder}
          value={value}
          onChange={onChange}
          maxLength={maxLength}
        />
      )}

      {variant === "card" && (
        <label className="relative w-full flex items-center">
          {icon && (
            <span className="h-5 w-5 text-black absolute left-3 top-1/2 transform -translate-y-1/2">
              {icon}
            </span>
          )}
          <input
            name={name}
            type="text"
            placeholder="1234 5678 9012 3456"
            value={cardNumber}
            onChange={handleCardNumberChange}
            maxLength={19}
            className={`p-3 w-full bg-field-bg rounded-lg outline-none focus:bg-field-bg/80 transition-colors text-sm placeholder:text-sm placeholder:text-secondary-text text-black border border-transparent ${
              disabled && "text-center cursor-not-allowed"
            } ${icon ? "pl-12" : ""}`}
          />
        </label>
      )}
    </>
  );
};
