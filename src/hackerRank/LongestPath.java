/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Suppose we represent our file system as a string. For example, the string "user\n\tpictures\n\tdocuments\n\t\tnotes.txt" represents:

user
    pictures
    documents
        notes.txt    
The directory user contains an empty sub-directory pictures and a sub-directory documents containing a file notes.txt.

The string "user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt" represents:

user
    pictures
        photo.png
        camera
    documents
        lectures
            notes.txt
The directory user contains two sub-directories pictures and documents. pictures contains a file photo.png and an empty second-level sub-directory camera. documents contains a second-level sub-directory lectures containing a file notes.txt.

We want to find the longest (as determined by the number of characters) absolute path to a file within our system. For example, in the second example above, the longest absolute path is "user/documents/lectures/notes.txt", and its length is 33 (not including the double quotes).

Given a string representing the file system in this format, return the length of the longest absolute path to a file in the abstracted file system. If there is not a file in the file system, return 0.

Example

For fileSystem = "user\n\tpictures\n\tdocuments\n\t\tnotes.txt", the output should be

longestPath(fileSystem) = 24.

The longest path is "user/documents/notes.txt", and it consists of 24 characters.
 *
 */
public class LongestPath {
	int longestPath(String fileSystem) {
		String[] dirs = fileSystem.replace("\\r", "#").split("#");
		Stack<String> stack = new Stack<>();
		int max = 0;
		int len = 0;
		for (String str : dirs) {
			// System.out.println(str);
			int lastTab = str.lastIndexOf("\\t");
			int tabs = (lastTab + 2) / 2; // tab count
			String name = lastTab == -1 ? str + "/" : str.substring(lastTab + 2) + "/";
			while (tabs != stack.size()) { // get parent directory.
				String parent = stack.pop();
				len -= parent.length();
			}
			if (name.indexOf(".") != -1) {
				max = Math.max(max, len + name.length() - 1);
			} else {
				stack.push(name);
				len += name.length();
			}

		}
		return max;
	}

}
