import Image from "next/image";
import { useEffect, useState } from "react";
import { getBooks } from "../service/bookService";

export default function Home() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    getAllBoooks();
  })

  async function getAllBoooks() {
    const allBooks = await getBooks("/books");
    setBooks(allBooks);

    }
  return (
    <>
      <div>
        <h1>TOTAL BOOKS ARE</h1>
        <p>
          {books.map((book:any) => (
            <div key={book.bookID}>
              {/* <Image
                src={book.bookImageURL}
                alt="book"
                width={100}
                height={100}
              /> */}
              <p>{book.bookTitle}</p>
              <p>{book.bookPrice}</p>
            </div>
          ))  
          }
        </p>
      </div>
    </>
  );
}
