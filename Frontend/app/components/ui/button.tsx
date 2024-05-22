"use client";

// TODO: адаптировать кнопку под разные экраны

import Link from "next/link";

interface IButton {
  variant?: "default" | "icon" | "link";
  icon?: React.ReactNode;
  color?: "light" | "dark";
  href?: string;
  onClick?: React.MouseEventHandler<HTMLButtonElement | HTMLAnchorElement>;
  children?: React.ReactNode;
}

export const Button = ({
  variant = "default",
  icon,
  color = "light",
  href,
  onClick,
  children,
}: IButton) => {
  return (
    <>
      {/* текстовая кнопка */}
      {variant === "default" && (
        <button
          onClick={onClick}
          className={`w-full rounded-lg p-3 text-white font-semibold flex items-center justify-center ${
            color === "light"
              ? "bg-button-accent hover:bg-button-accent/85"
              : "bg-button-dark-accent hover:bg-button-dark-accent/85"
          } transition-colors`}
        >
          {children}
        </button>
      )}
      {/* кнопка-иконка */}
      {variant === "icon" && icon && (
        <button
          onClick={onClick}
          className="w-max rounded-lg p-2.5 text-icon bg-transparent hover:text-icon/90 hover:bg-transparent/10 transition-colors flex items-center justify-center"
        >
          {icon}
        </button>
      )}
      {/* кнопка-ссылка */}
      {variant === "link" && href && (
        <Link
          className="text-link underline underline-offset-2 font-medium hover:text-link/80 hover:underline-offset-4 transition-all"
          href={href}
        >
          {children}
        </Link>
      )}
    </>
  );
};
