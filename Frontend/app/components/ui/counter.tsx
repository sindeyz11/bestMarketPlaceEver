"use client";

import { useState } from "react";

export const Counter = () => {
  const [count, setCount] = useState<number>(0);
  return (
    <div className="flex items-center p-1.5 border border-black rounded-lg outline-none h-full">
      <button
        onClick={() => count > 0 && setCount(count - 1)}
        className="font-semibold text-secondary-text text-xl px-2"
      >
        -
      </button>
      <input
        value={count}
        onChange={(e) => setCount(Number(e.target.value))}
        type="number"
        className={`text-center w-full placeholder:text-secondary-text h-full outline-none`}
      />
      <button
        onClick={() => setCount(count + 1)}
        className="font-semibold text-secondary-text text-xl px-2"
      >
        +
      </button>
    </div>
  );
};
