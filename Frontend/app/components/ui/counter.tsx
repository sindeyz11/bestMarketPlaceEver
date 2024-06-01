"use client";

interface CounterProps {
  quantity: number;
  setQuantity: (quantity: number) => void;
}

export const Counter = ({ quantity, setQuantity }: CounterProps) => {
  return (
    <div className="flex items-center p-1.5 border border-black rounded-lg outline-none h-full">
      <button
        onClick={() => quantity > 0 && setQuantity(quantity - 1)}
        className="font-semibold text-secondary-text text-xl px-2"
      >
        -
      </button>
      <input
        value={quantity}
        onChange={(e) => setQuantity(Number(e.target.value))}
        type="number"
        className={`text-center w-full placeholder:text-secondary-text h-full outline-none`}
      />
      <button
        onClick={() => setQuantity(quantity + 1)}
        className="font-semibold text-secondary-text text-xl px-2"
      >
        +
      </button>
    </div>
  );
};
