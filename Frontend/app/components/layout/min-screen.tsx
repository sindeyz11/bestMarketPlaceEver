import Image from "next/image";

export const MinScreen = () => {
  return (
    <div className="base:hidden h-screen bg-footer-bg text-white flex items-center justify-center">
      <div className="flex flex-col gap-4 items-center p-12">
        <h1 className="text-2xl font-bold text-center">
          Ой! Ваш экран слишком маленький.
        </h1>
        <p className="text-center">
          Чтобы продолжить работу с нашим интернет-магазином на экранах с
          маленьким разрешением, пожалуйста, скачайте приложение:
        </p>
        <div className="flex gap-6">
          <div className="flex gap-4 items-center">
            <Image
              src="/qr-codes/android-app.png"
              width={80}
              height={80}
              alt="Скачайте приложение KubMarket для Android"
            />
            <h4 className="text-lg font-semibold">Приложение для Android</h4>
          </div>
        </div>
      </div>
    </div>
  );
};
