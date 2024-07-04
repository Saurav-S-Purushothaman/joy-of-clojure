(ns joy-of-clojure.clj-pdf
  (:require [clj-pdf-markdown.core :refer [markdown->clj-pdf]]
            [clj-pdf.core :as pdf])
  (:gen-class))

(def my-markdown
  (str "
### Instructions for Conversion:

1. **Using Pandoc** (Command-line tool for conversion):

   - Save the Markdown content to a file, e.g., `sample.md`.
   - Open a terminal or command prompt.
   - Use the following command to convert Markdown to PDF:
     ```sh
     pandoc sample.md -o sample.pdf
     ```
   - This command converts `sample.md` to `sample.pdf`.

2. **Using Online Converters**:
   - Copy the Markdown content.
   - Use an online Markdown to PDF converter (such as `https://www.markdowntopdf.com/` or similar).
   - Paste the Markdown content into the converter and follow the instructions to generate the PDF.

3. **Using Markdown Editors**:
   - Some Markdown editors (like Typora, VS Code with extensions, etc.) can export Markdown files directly to PDF.
   - Open your Markdown editor, paste the content, and look for an export option that allows you to save as PDF.

### Additional Tips:
- Ensure your Markdown content is correctly formatted and free of syntax errors to avoid issues during conversion.
- Adjust styling and layout as needed in the Markdown content to suit your preferences before converting to PDF.

By following these steps and using suitable tools, you can easily convert Markdown content to PDF format for various documentation purposes.
"))
