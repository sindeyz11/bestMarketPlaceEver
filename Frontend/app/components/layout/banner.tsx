// TODO: адаптировать!

import { Button } from "@/components/ui/button";

export const Banner = () => {
  return (
    <>
      <div className="w-full relative">
        <img src="/under-banner.png" alt="" className="w-full" />
        <div className="absolute top-12 bottom-12 right-32 left-32 bg-white rounded-xl grid grid-cols-3 px-32">
          <div className="col-span-2 flex flex-row items-center gap-40 w-full">
            <div className="flex flex-col gap-3">
              <div className="flex flex-col gap-3">
                <h1 className="text-black font-extrabold text-6xl uppercase">
                  Помидоры
                </h1>
                <h3 className="text-secondary-text text-2xl w-72">
                  Настолько вкусные, что обоссаться можно
                </h3>
              </div>
              <div className="w-40 mt-8">
                <Button>Купить</Button>
              </div>
            </div>
            <div className="flex flex-col justify-end">
              <div className="flex items-start">
                <h1 className="text-green-600 font-extrabold text-6xl uppercase">
                  ₽250.00
                </h1>
                <sup>
                  <del className="text-3xl font-bold text-secondary-text">
                    ₽300.00
                  </del>
                </sup>
              </div>
              <h3 className="text-2xl w-1/2 font-bold text-secondary-text">
                ОГРАНИЧЕННОЕ ПРЕДЛОЖЕНИЕ
              </h3>
            </div>
          </div>
          <div className="col-span-1 relative">
            <img src="/pomodoro.png" alt="" className="h-full absolute" />
          </div>
        </div>
      </div>
    </>
  );
};
