export const Badge = ({ children }: { children: React.ReactNode }) => {
  return (
    <div className="absolute bottom-5 left-4 w-3 h-3 flex items-center justify-center bg-dark-accent px-3 py-2 text-xs text-white font-bold rounded">
      {children}
    </div>
  );
};
