"use client";

import { DownArrowIcon } from "@/components/icons/down-arrow-icon";
import { useState, useEffect, useRef } from "react";

interface SelectProps {
  textByDefault?: string;
  options: string[];
  size?: "default" | "small";
}

export const Select = ({
  textByDefault,
  options,
  size = "default",
}: SelectProps) => {
  const [isOpened, setOpened] = useState<boolean>(false);
  const [currentOption, setCurrentOption] = useState<string>(
    textByDefault || options[0] || "",
  );

  const selectRef = useRef<HTMLDivElement>(null);

  const handleClickOutside = (event: MouseEvent) => {
    if (
      selectRef.current &&
      !selectRef.current.contains(event.target as Node)
    ) {
      setOpened(false);
    }
  };

  useEffect(() => {
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  return (
    <div
      className="relative"
      onClick={() => setOpened(!isOpened)}
      ref={selectRef}
    >
      <div
        className={`relative w-full bg-white ${
          size === "default" ? "py-2.5" : "py-1"
        } rounded-lg border border-d-gray-500 outline-offset-0 cursor-pointer ${
          isOpened && "rounded-b-none"
        }`}
      >
        <span
          className={`pr-11 rounded-lg outline-none text-d-gray-500 ${
            size === "default" ? "" : "text-sm"
          } pl-3 select-none`}
        >
          {currentOption}
        </span>
        <DownArrowIcon
          className={`h-3.5 w-3.5 text-d-gray-500 absolute top-1/2 -translate-y-[50%] right-3 transition-all ${
            isOpened && "origin-center rotate-180"
          }`}
        />
      </div>
      {isOpened && (
        <ul
          className={`bg-white w-full absolute ${
            size === "default" ? "top-11" : "top-8"
          } rounded-b-lg border-black/10 border border-t-black/10 text-sm`}
        >
          {options &&
            options.map((option) => (
              <li
                key={option}
                className={`text-black hover:bg-d-red-400 cursor-pointer transition-all hover:text-white hover:bg-button-dark-accent ${
                  size === "default" && "px-2"
                } ${
                  size === "small" && "px-1 text-sm"
                } -z-10 last:rounded-b-lg `}
                onClick={() => {
                  setCurrentOption(option);
                  setOpened(false);
                }}
              >
                {option}
              </li>
            ))}
        </ul>
      )}
    </div>
  );
};
