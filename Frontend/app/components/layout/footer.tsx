import Image from "next/image";
import { useState, useEffect } from "react";

export const Footer = () => {
  const [currentYear, setCurrentYear] = useState(new Date().getFullYear());

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentYear(new Date().getFullYear());
    }, 60000);

    return () => clearInterval(interval);
  }, []);

  return (
    <footer className="p-10 bg-footer-bg w-full flex items-center justify-between">
      <p className="w-1/3 max-w-1/2 text-white text-sm">
        {currentYear} © KubMarket — потрясающий интернет-магазин всякого
        барахла. Ваши и наши права не защищены. Работаем только самовывозом. На
        Торговой площадке не применяются технологии. Не мошенники. Адрес
        для направления юридически значимых сообщений отсутствует.
      </p>
      <div className="flex items-center gap-6">
        <h3 className="font-bold text-white mb-6 text-end">
          Загрузите наше <br /> приложение
        </h3>
        <div className="flex flex-col items-center gap-1">
          <Image
            src="/qr-codes/android-app.png"
            width={80}
            height={80}
            alt="Скачайте приложение KubMarket для Android"
          />
          <h3 className="font-bold text-white">Android</h3>
        </div>
      </div>
    </footer>
  );
};
