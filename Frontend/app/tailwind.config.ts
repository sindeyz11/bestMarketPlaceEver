import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
      colors: {
        "primary-text": "#000000",
        "secondary-text": "#6E6E6E",
        "field-bg": "#EBEBEB",
        accent: "#C92E2E",
        "selected-field": "#FFC3C3",
        "footer-bg": "#8A2525",
        "button-accent": "#F93F3F",
        "button-dark-accent": "#B20000",
      },
    },
  },
  plugins: [],
};
export default config;
