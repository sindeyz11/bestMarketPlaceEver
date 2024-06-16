"use client";

import { Footer } from "@/components/layout/footer";
import { Header } from "@/components/layout/header";
import Loader from "@/components/layout/loader";
import { Inter } from "next/font/google";
import Image from "next/image";
import { useEffect, useState } from "react";
import { Toaster } from "react-hot-toast";
import { useMedia } from "use-media";
import "./globals.css";
import { loadToken } from "@/utils/load-token";
import { useRouter } from "next/navigation";

const inter = Inter({ subsets: ["latin"] });

const RootLayout = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  const [isLoading, setIsLoading] = useState(true);
  const tabletBreakpoint = useMedia({ maxWidth: "992px" });
  const router = useRouter();

  useEffect(() => {
    const timeout = setTimeout(() => {
      setIsLoading(false);
    }, 1500);

    return () => clearTimeout(timeout);
  }, []);

  return (
    <html lang="ru">
      <body className={`${inter.className}`}>
        <Toaster position="bottom-right" />
        {isLoading ? (
          <Loader />
        ) : (
          <div className="">
            {tabletBreakpoint ? (
              <div className="h-screen bg-footer-bg text-white flex items-center justify-center">
                <div className="flex flex-col gap-4 items-center p-12">
                  <h1 className="text-2xl font-bold text-center">
                    Ой! Ваш экран слишком маленький.
                  </h1>
                  <p className="text-center">
                    Чтобы продолжить работу с нашим интернет-магазином на
                    экранах с маленьким разрешением, пожалуйста, скачайте
                    приложение:
                  </p>
                  <div className="flex gap-6">
                    <div className="flex gap-4 items-center">
                      <Image
                        src="/qr-codes/android-app.png"
                        width={80}
                        height={80}
                        alt="Скачайте приложение KubMarket для Android"
                      />
                      <h4 className="text-lg font-semibold">
                        Приложение для Android
                      </h4>
                    </div>
                  </div>
                </div>
              </div>
            ) : (
              <>
                <Header />
                <div style={{ minHeight: "calc(100vh - 240px)" }}>
                  {children}
                </div>
                <Footer />
              </>
            )}
          </div>
        )}
      </body>
    </html>
  );
};

export default RootLayout;
