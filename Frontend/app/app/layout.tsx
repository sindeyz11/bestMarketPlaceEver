"use client";

import { Inter } from "next/font/google";
import "./globals.css";
import { useMedia } from "use-media";

const inter = Inter({ subsets: ["latin"] });

const RootLayout = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  const tabletBreakpoint = useMedia({ maxWidth: "992px" });
  return (
    <html lang="ru">
      {tabletBreakpoint ? (
        <body>Слишком маленький экран, скачайте приложение</body>
      ) : (
        <body className={inter.className}>{children}</body>
      )}
    </html>
  );
};

export default RootLayout;
