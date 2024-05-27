import { Button } from "@/components/ui/button";

export const Banner = () => {
  return (
    <>
      <div className="w-full relative">
        <img src="/under-banner.png" alt="" className="h-[25em] w-full" />
        <div className="absolute top-0 left-0 bottom-0 right-0 opacity-40 bg-gray-200"></div>
        <div className="absolute top-10 left-20 bottom-10 right-20 bg-white rounded-xl flex items-center justify-between px-20">
          <div className="flex items-start gap-10">
            <div className="flex flex-col gap-2">
              <h1 className="text-black font-bold uppercase text-5xl">
                Помидоры
              </h1>
              <p className="text-secondary-text w-1/2">
                Просто очень вкусные помидоры, далее описание для баннера
              </p>
              <span className="w-[10em]">
                <Button>Купить</Button>
              </span>
            </div>
            <div className="2xl:flex flex-col gap-2 hidden mr-[10em]">
              <div className="relative">
                <h3 className="text-3xl text-green-600 font-bold">₽250.00</h3>
                <s className="absolute text-xl font-semibold text-secondary-text -top-4 -right-16">
                  ₽300.00
                </s>
              </div>
              <span className="text-base font-bold text-secondary-text w-[10em] uppercase leading-none">
                Огранниченное предложение
              </span>
            </div>
          </div>
          <img src="./pomodoro.png" className="h-[20em]" />
        </div>
      </div>
    </>
  );
};
